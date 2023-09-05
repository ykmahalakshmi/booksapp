package com.example.booksapp1.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "roles")
    public class Roles {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int role_id;
        private String rolename;
        @OneToMany(mappedBy = "roles")
        @JsonIgnore // ignore the property from serialization
        private List<Users> users = new ArrayList<Users>();

        public int getRole_id() {
            return role_id;
        }

        public void setRole_id(int role_id) {
            this.role_id = role_id;
        }

        public String getRolename() {
            return rolename;
        }

        public void setRolename(String rolename) {
            this.rolename = rolename;
        }

        public List<Users> getUsers() {
            return users;
        }

        public void setUsers(List<Users> users) {
            this.users = users;
        }
    }

