/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velvet.m.server;

/**
 *
 * @author selbecam
 */
class Player {
    private GenericAvatar avatar = new MonopolyAvatar();
    private String name;
    private static int id = 0;
    
    Player(String name) {
        avatar.setAvatar();
        this.name = name;
        id++;
    }
    
    Player(String name, String a) throws InvalidAvatarException{
        avatar.setAvatar(a);
        this.name = name;
        id++;
    }
    
    String getPlayerName() { 
        return this.name;
    }
    
    AvatarType getPlayerAvatarType() {
        return (AvatarType)avatar.getAvatar();
    }
    
    int getPlayerId() {
        return id;
    }
}

class TestPlayer {
    public static void main (String[] args) {
        Player p1 = new Player("camilla");
        System.out.println("p1 name " + p1.getPlayerName() + " avatar " 
                + p1.getPlayerAvatarType() + " id " + p1.getPlayerId());
        try {
            Player p2 = new Player("nisse", "cat");
            System.out.println("p2 name " + p2.getPlayerName() + " avatar " 
                    + p2.getPlayerAvatarType() + " id " + p1.getPlayerId());
        } catch(InvalidAvatarException e){
            System.out.println("Not a valid avatar");
        }
    }
}