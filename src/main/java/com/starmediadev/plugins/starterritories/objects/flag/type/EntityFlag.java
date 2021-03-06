package com.starmediadev.plugins.starterritories.objects.flag.type;

import com.starmediadev.plugins.starterritories.objects.flag.*;
import org.bukkit.entity.*;

public class EntityFlag extends TypeFlag<EntityType> {
    
    public EntityFlag(String name, boolean requiresPlayer, FlagValue defaultTypeValue) {
        super(name, requiresPlayer, defaultTypeValue);
    }
    
    @Override
    public EntityType convertInput(String input) {
        return EntityType.valueOf(input.toUpperCase());
    }
    
    @Override
    public boolean isValidType(Object object) {
        return object instanceof EntityType;
    }
    
    @Override
    protected FlagValue checkRestricted(Player player, Object object) {
        if (this.value == FlagValue.RESTRICTED) {
            if (object instanceof EntityType entityType) {
                return types.getOrDefault(entityType, this.defaultTypeValue);
            }
        }
        
        return this.value;
    }
}
