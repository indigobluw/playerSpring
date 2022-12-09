package com.example.Tenta.Player;

import javax.persistence.*;

    @Entity
    @Table
    public class Player {
        @Id
        @SequenceGenerator(
                name = "player_sequence",
                sequenceName = "player_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "player_sequence"
        )
        private Long id;
        private String name;
        private Integer score;

        public Player() {
        }

        public Player(Long id, String name, Integer score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public Player(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }