package com.example.booksapp1.entities;
import com.example.booksapp1.Enum.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "roles")
    public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int role_id;
        @Column(name = "rolename")
        @Enumerated(EnumType.STRING)
        private RoleName rolename;
        @OneToMany(mappedBy = "roles")
        @JsonIgnore // ignore the property from serialization
        private List<User> users = new ArrayList<User>();

        public int getRole_id() {
            return role_id;
        }

        public void setRole_id(int role_id) {
            this.role_id = role_id;
        }

        public RoleName getRolename() {
            return rolename;
        }

        public void setRolename(RoleName rolename) {
            this.rolename = rolename;
        }

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }
    }

