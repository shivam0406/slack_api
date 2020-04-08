package com.slack;


import com.slack.channel.Conversation;
import com.slack.utils.ChannelNameGenerator;
import com.slack.utils.ResponseUtils;
import com.slack.utils.Token;

import org.apache.http.HttpHeaders;


import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class CreateChannelTest extends BaseTest {


    @Test
    public void createChannel() throws IOException {
        System.out.println("we are here to create slack channel");
        HttpPost request = new HttpPost(BASE_ENDPOINT_SLACK + "conversations.create");
        request.addHeader("Authorization", "Bearer " + Token.getToken());
        request.setHeader(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.APPLICATION_JSON));
        String value = ChannelNameGenerator.getChannelName();
        System.out.println("VALUE Is" + value);
        String json = "{\"name\":\"" + value + "\"}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Conversation channel = ResponseUtils.unmarshallGeneric(response, Conversation.class);
        System.out.println(channel.getError());
        Assert.assertTrue(channel.isOk());
        //System.out.println(channel.getError());
        Assert.assertEquals(channel.getChannel().getPrevious_names().length, 0);
        Assert.assertTrue(channel.getChannel().is_channel());
        slack.put("channelName", channel.getChannel().getName());
        slack.put("channelID", channel.getChannel().getId());
    }


    @Test
    public void joinChannel() throws IOException {
        HttpPost request = new HttpPost(BASE_ENDPOINT_SLACK + "conversations.join");
        request.addHeader("Authorization", "Bearer " + Token.getToken());
        request.setHeader(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.APPLICATION_JSON));
        String json = "{\"channel\":\"" + slack.get("channelID") + "\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Conversation channel = ResponseUtils.unmarshallGeneric(response, Conversation.class);
        Assert.assertTrue(channel.isOk());
    }

    @Test
    public void renameChannel() throws IOException {
        HttpPost request = new HttpPost(BASE_ENDPOINT_SLACK + "conversations.rename");
        request.addHeader("Authorization", "Bearer " + Token.getToken());
        request.setHeader(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.APPLICATION_JSON));
        String json = "{\"channel\": \"" + slack.get("channelID") + "\",\"name\": \"" + ChannelNameGenerator.getChannelName() + "\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Conversation channel = ResponseUtils.unmarshallGeneric(response, Conversation.class);
        Assert.assertTrue(channel.isOk());
        Assert.assertEquals(channel.getChannel().getPrevious_names()[0], slack.get("channelName"));
        slack.put("updatedChannelName", channel.getChannel().getName());
    }

     @Test
    public void getChannelList() throws IOException {
        HttpGet request = new HttpGet(BASE_ENDPOINT_SLACK + "conversations.list");
        request.addHeader("Authorization", "Bearer " + Token.getToken());
        response = client.execute(request);
        Conversation conversation = ResponseUtils.unmarshallGeneric(response, Conversation.class);
       // ValidateTheRenameUsingArrayList.verify(conversation.getChannels());
        for(int i =0; i<conversation.getChannels().length; i++)
        {
            System.out.println(slack.get("channelID"));
            System.out.println(slack.get("channelID"));
            if(conversation.getChannels()[i].getId().equalsIgnoreCase(slack.get("channelID"))){
                System.out.println("Matched");
                System.out.println(conversation.getChannels()[i].getName());
                Assert.assertEquals(conversation.getChannels()[i].getPrevious_names()[0], slack.get("channelName"));
                Assert.assertEquals(conversation.getChannels()[i].getName(), slack.get("updatedChannelName"));
                break;
            }
            else {
                System.out.println("Looping");
            }

        }
    }

    @Test
    public void archiveTheChannel() throws IOException {
        HttpPost request = new HttpPost(BASE_ENDPOINT_SLACK + "conversations.archive");
        request.addHeader("Authorization", "Bearer " + Token.getToken());
        request.setHeader(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.APPLICATION_JSON));
        String json = "{\"channel\":\"" + slack.get("channelID") + "\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Conversation channel = ResponseUtils.unmarshallGeneric(response, Conversation.class);
        System.out.println(channel.getError());
        Assert.assertTrue(channel.isOk());

    }

    @Test
    public void validateAarchivedChannel() throws IOException {
        HttpPost request = new HttpPost(BASE_ENDPOINT_SLACK + "conversations.archive");
        request.addHeader("Authorization", "Bearer " + Token.getToken());
        request.setHeader(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.APPLICATION_JSON));
        String json = "{\"channel\":\"" + slack.get("channelID") + "\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Conversation channel = ResponseUtils.unmarshallGeneric(response, Conversation.class);
        System.out.println(channel.getError());
        Assert.assertFalse(channel.isOk());
        Assert.assertEquals(channel.getError(), "already_archived");

    }


}
