package com.ozerian.app.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

/**
 * Class for representation of Letter (email message) entity.
 */
@Entity
@Table(name = "letters")
public class Letter {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "subject")
    private String subject;

    @Column(name = "content")
    private String letterContent;

    @Column(name = "sentDate")
    private Date letterDate;

    @Column(name = "attachments")
    private String path;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Letter() {
    }

    public Letter(String sender, String subject, String letterContent, Date letterDate, Profile profile) {
        this.sender = sender;
        this.subject = subject;
        this.letterContent = letterContent;
        this.letterDate = letterDate;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLetterContent() {
        return letterContent;
    }

    public void setLetterContent(String letterContent) {
        this.letterContent = letterContent;
    }

    public Date getLetterDate() {
        return letterDate;
    }

    public void setLetterDate(Date letterDate) {
        this.letterDate = letterDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Letter)) return false;

        Letter letter = (Letter) o;

        if (id != null ? !id.equals(letter.id) : letter.id != null) return false;
        if (sender != null ? !sender.equals(letter.sender) : letter.sender != null) return false;
        if (subject != null ? !subject.equals(letter.subject) : letter.subject != null) return false;
        if (letterContent != null ? !letterContent.equals(letter.letterContent) : letter.letterContent != null)
            return false;
        if (letterDate != null ? !letterDate.equals(letter.letterDate) : letter.letterDate != null) return false;
        if (path != null ? !path.equals(letter.path) : letter.path != null) return false;
        return profile != null ? profile.equals(letter.profile) : letter.profile == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (letterContent != null ? letterContent.hashCode() : 0);
        result = 31 * result + (letterDate != null ? letterDate.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        return result;
    }
}
