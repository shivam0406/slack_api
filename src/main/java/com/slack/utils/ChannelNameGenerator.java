package com.slack.utils;

import java.util.ArrayList;
import java.util.Random;

public class ChannelNameGenerator {


    static String channel = "automatedchannel";

    public static String getChannelName() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> contains = new ArrayList<>();
        int k = -1;
        channel = channel.replaceAll(" ", "");
        for (int i = 0; i < channel.length(); i++) {
            k = -1;

            for (int j = i + 4; j < channel.length() + 1; j++) {
                stringArrayList.add(channel.substring(k + 1, j));
                k++;
            }
        }

        Random random = new Random();
        int max = random.nextInt(stringArrayList.size());
        if (!contains.contains(max)) {
            contains.add(max);
        }

        int length = stringArrayList.size();
        int randomindex = 0 + (int) (Math.random() * length - 1);
        String str = stringArrayList.get(randomindex);


        return str;
    }
}

