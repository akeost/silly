package com.velvet.m.server;

/**
 * 
 * @author selbecam
 * 
 */
public abstract class GenericAvatar{
    
    /**
     * Getter method for avatar
     * @return an avatar
     */
    abstract <T extends Object> T getAvatar();
    
    /**
     * Sets an available avatar.
     */
    abstract void setAvatar();
    
    /**
     * Sets an avatar if myAvatar matches any vacant avatar. 
     * @param myAvatar a string representation of the wanted avatar.
     * @return true if the avatar was vacant, otherwise false
     * @throws InvalidAvatarException myAvatar not a valid avatar
     */
    abstract boolean setAvatar(String myAvatar) throws InvalidAvatarException; 
     
      
}

class InvalidAvatarException extends Exception {}
