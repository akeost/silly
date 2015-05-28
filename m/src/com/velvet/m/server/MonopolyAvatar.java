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

enum AvatarType {TOPHAT, SCOTTYDOG, WHEELBARROW, BATTLESHIP, BOOT, CAT, RACECAR, 
              THIMBLE, DEFAULT;
    boolean occupied = false;
    
    void setAvatarTypeOccupied() {
        occupied = true;
    }
}

/**
 * 
 * @author selbecam
 */
public class MonopolyAvatar extends GenericAvatar{
    private AvatarType avatar = AvatarType.DEFAULT;
    /**
     * Getter method for avatar
     * @return an avatar
     */
    @Override
    AvatarType getAvatar(){
        return avatar;
    }
    
    /**
     * Sets an avatar if myAvatar matches any vacant avatar. 
     * @param myAvatar a string representation of the wanted avatar.
     * @return true if selection of avatar went well, otherwise false
     * @throws InvalidAvatarException 
     */
    @Override
    boolean setAvatar(String myAvatar) throws InvalidAvatarException{
        boolean success = false;     
        
        //TODO Create method that performs check, add and set occupied
        switch (myAvatar.toLowerCase()) {
        case "tophat":
            setAvatar(AvatarType.TOPHAT);
            break;
        case "scottydog":
            setAvatar(AvatarType.SCOTTYDOG);
            break;
        case "wheelbarrow":
            setAvatar(AvatarType.WHEELBARROW);
            break;
        case "battleship":
            setAvatar(AvatarType.BATTLESHIP);
            break;
        case "boot":
            setAvatar(AvatarType.BOOT);
            break;
        case "cat":
            setAvatar(AvatarType.CAT);
            break;
        case "racecar":
            setAvatar(AvatarType.RACECAR);
            break;
        case "thimble":
            setAvatar(AvatarType.THIMBLE);
            break;
        default:
            throw new InvalidAvatarException();
        }
        
        return success;
    }
    
    /**
     * Sets an available avatar.
     */
    @Override
    void setAvatar() {
        
        for (AvatarType a: AvatarType.values()){
            
            if (setAvatar(a)){
                break;
            }
        }
    }
    
    /**
     * Sets an avatar if myAvatar matches any vacant avatar
     * @param myAvatar enum for the vanted avatar
     * @return 
     */
    boolean setAvatar(AvatarType myAvatar) {
        boolean set = false;
        if(!myAvatar.occupied){
            avatar = myAvatar;
            avatar.setAvatarTypeOccupied();
            set = true;
        }
        return set;
    }
}


class TestAvatar{
    public static void main(String[] args) {
        String myAvatar = "boot";
        boolean avatar;
        GenericAvatar a = new MonopolyAvatar();
        GenericAvatar a2 = new MonopolyAvatar();
        
        try {
            avatar = a.setAvatar(myAvatar);
            System.out.println("Avatar is: " + a.getAvatar() + " " + avatar);
            a2.setAvatar();
            System.out.println("Avatar2 is: " + a2.getAvatar());
        } catch (InvalidAvatarException e) {
            System.out.println("Not a valid avatar: " + myAvatar);
        } 
        
        for (AvatarType a3: AvatarType.values()) {
            System.out.println(a3 + " " +a3.occupied);
        }
    }
}
