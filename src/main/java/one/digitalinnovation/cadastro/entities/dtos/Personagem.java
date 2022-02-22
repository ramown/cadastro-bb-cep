package one.digitalinnovation.cadastro.entities.dtos;

import java.util.ArrayList;

public class Personagem {
        private String name;
        private String birthday;
        private ArrayList<String> occupation;
        private String img;
        private String nickname;

        public Personagem() {
        }

        public Personagem(String name, String birthday, ArrayList<String> occupation, String img, String nickname) {
                this.name = name;
                this.birthday = birthday;
                this.occupation = occupation;
                this.img = img;
                this.nickname = nickname;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getBirthday() {
                return birthday;
        }

        public void setBirthday(String birthday) {
                this.birthday = birthday;
        }

        public ArrayList<String> getOccupation() {
                return occupation;
        }

        public void setOccupation(ArrayList<String> occupation) {
                this.occupation = occupation;
        }

        public String getImg() {
                return img;
        }

        public void setImg(String img) {
                this.img = img;
        }

        public String getNickname() {
                return nickname;
        }

        public void setNickname(String nickname) {
                this.nickname = nickname;
        }
}
