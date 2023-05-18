package infsus.closet.closet.DTO;

import infsus.closet.closet.model.Clothes;
import infsus.closet.closet.model.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

public class CommentDTO {
    private String content;

    private Timestamp postingDate = new Timestamp(System.currentTimeMillis());

    private ProfileDTO profile;

    private ClothesDTO clothes;

    // getters and setters

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Timestamp postingDate) {
        this.postingDate = postingDate;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    public ClothesDTO getClothes() {
        return clothes;
    }

    public void setClothes(ClothesDTO clothes) {
        this.clothes = clothes;
    }
}
