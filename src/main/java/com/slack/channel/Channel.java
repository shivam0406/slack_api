package com.slack.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Channel {


    private String id;

    private String name;

    @Getter
    @Setter
    @JsonProperty
    private boolean is_channel;


    @Getter
    @Setter
    @JsonProperty
    private boolean is_group;

    @Getter
    @Setter
    @JsonProperty
    private boolean is_im;

    private Number created;

    @Getter
    @Setter
    @JsonProperty
    private boolean is_archived;


    @Getter
    @Setter
    @JsonProperty
    private boolean is_general;


    private Number unlinked;


    private String creator;


    private String name_normalized;


    @Getter
    @Setter
    @JsonProperty
    private boolean is_shared;


    @Getter
    @Setter
    @JsonProperty
    private boolean is_org_shared;

    private String[] shared_team_ids;

    private String parent_conversation;

    @Getter
    @Setter
    @JsonProperty
    private boolean is_member;

    private String[] pending_shared;

    private String[] pending_connected_team_ids;

    @Getter
    @Setter
    @JsonProperty
    private boolean is_pending_ext_shared;


    @Getter
    @Setter
    @JsonProperty
    private boolean is_private;


    @Getter
    @Setter
    @JsonProperty
    private boolean is_mpim;


    private String last_read;


    private String latest;


    private Number unread_count;


    private Number unread_count_display;

    @Getter
    @Setter
    @JsonProperty
    private boolean is_ext_shared;

    private String[] members;


    private Topic topic;


    private Purpose purpose;


    private String[] previous_names;


    private Number priority;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getCreated() {
        return created;
    }

    public void setCreated(Number created) {
        this.created = created;
    }

    public Number getUnlinked() {
        return unlinked;
    }

    public void setUnlinked(Number unlinked) {
        this.unlinked = unlinked;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName_normalized() {
        return name_normalized;
    }

    public void setName_normalized(String name_normalized) {
        this.name_normalized = name_normalized;
    }

    public String getLast_read() {
        return last_read;
    }

    public void setLast_read(String last_read) {
        this.last_read = last_read;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public Number getUnread_count() {
        return unread_count;
    }

    public void setUnread_count(Number unread_count) {
        this.unread_count = unread_count;
    }

    public Number getUnread_count_display() {
        return unread_count_display;
    }

    public void setUnread_count_display(Number unread_count_display) {
        this.unread_count_display = unread_count_display;
    }

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }


    public String[] getPrevious_names() {
        return previous_names;
    }

    public void setPrevious_names(String[] previous_names) {
        this.previous_names = previous_names;
    }

    public Number getPriority() {
        return priority;
    }

    public void setPriority(Number priority) {
        this.priority = priority;
    }

    public String getParent_conversation() {
        return parent_conversation;
    }

    public void setParent_conversation(String parent_conversation) {
        this.parent_conversation = parent_conversation;
    }

    public String[] getShared_team_ids() {
        return shared_team_ids;
    }

    public void setShared_team_ids(String[] shared_team_ids) {
        this.shared_team_ids = shared_team_ids;
    }

    public String[] getPending_shared() {
        return pending_shared;
    }

    public void setPending_shared(String[] pending_shared) {
        this.pending_shared = pending_shared;
    }

    public String[] getPending_connected_team_ids() {
        return pending_connected_team_ids;
    }

    public void setPending_connected_team_ids(String[] pending_connected_team_ids) {
        this.pending_connected_team_ids = pending_connected_team_ids;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }
}
