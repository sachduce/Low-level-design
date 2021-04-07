package StackOverflow;

import java.util.Date;
import java.util.List;
import java.util.Map;

class User {
    int guestId;
    Search searchObj;
    public List<Question>getQuestions(String searchString);
}

class Member extends User{
    Account account;
    List<Badge> badges;

    public void addQuestion(Question question);
    public void addComment(Entity entity, Comment comment);
    public void addAnswer(Question question, Answer answer);
    public void vote(Entity entity, VoteType voteType);
    public void addTag(Question question, Tag tag);
    public void flag(Entity entity);
    public List<Badge> getBadges();
}

class Account{
    int accountId;
    String name;
    Address address;
    String userName;
    String password;
    AccountStatus accountStatus;
    int reputation;
}

class Address{
    String country;
    String state;
    String city;
    String street;
    String pinCode;
}

class Moderator extends Member{
    public Boolean closeQuestion(Question question);
    public Boolean restoreQuestion(Question question);
}

class Admin extends Member{
    public Boolean blockMember(Member member);
    public Boolean unBlockMember(Member member);
}

enum AccountStatus{
    BLOCKED, ACTIVE, CLOSED;
}

enum VoteType{
    UPVOTE, DOWNVOTE, CLOSEVOTE, DELETEVOTE
}

class Badge{
    String name;
    String description;
}

class Entity{
    int entityId;
    Member member;
    Map<VoteType, Integer> votes;
    Date createdDate;
    List<Comment> comments;

    public Boolean flagEntity(Member member);
    public Boolean voteEntity(VoteType voteType);
    public Boolean addComment(Comment comment);
    
}

class Comment extends Entity{
    String message;
}

class Question extends Entity{
    List<EditHistory> editHistories;
    List<Answer> answers;
    List<Tag> tags;
    String title;
    String description;
    QuestionStatus questionStatus;

    public Boolean addQuestion(){
        return true;
    };
    public Boolean addTag(Tag tag){
        return true;
    }
}

class Answer extends Entity{
    String answer;
    Boolean isAccepted;
    public Boolean addAnswer(Question question){
        return true;
    };
}

enum QuestionStatus{
    ACTIVE, BOUNTIED, FLAGGED, CLOSED
}

class Tag{
    String name;
    String description;
}

class EditHistory{
    int editorHistoryId;
    Member creator;
    Date creationDate;
    Question prevQuestion;
    Question updatedQuestion;
}

class Search{
    // Write Search apis here
}