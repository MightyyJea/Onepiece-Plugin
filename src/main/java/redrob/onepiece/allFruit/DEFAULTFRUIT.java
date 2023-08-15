package redrob.onepiece.allFruit;

import redrob.onepiece.fruit.DevilFruit;
import redrob.onepiece.fruit.DevilType;

public class DEFAULTFRUIT extends DevilFruit {
    public DEFAULTFRUIT(){
        super(DevilType.DEFAULT, "DEFAULT");
    }
    public void DropInteraction(){
        this.getOwner().sendMessage("default interaction on drop");
    }

    public void SneakInteraction(){}

    public void RightClickInteraction(){}
    public void LeftClickInteraction(){}
}
