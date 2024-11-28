package azaria.chiselblocks.container.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class CraftingStationContainer implements Container {
    private final AbstractContainerMenu _menu;
    private final CraftingStationStackHandler _inventory;

    public CraftingStationContainer (
        AbstractContainerMenu menu,
        CraftingStationStackHandler inventory,
        int slots
    ) {
        _menu = menu;
        _inventory = inventory;
    }

    @Override
    public int getContainerSize () {
        return _inventory.getCount();
    }

    @Override
    public boolean isEmpty () {
        for (int i = 0; i < _inventory.getCount(); i++) {
            if (_inventory.getStackInSlot(i).isEmpty() == false) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem (int slot) {
        return _inventory.getStackInSlot(slot);
    }

    @Override
    public ItemStack removeItem (int slot, int amount) {
        var stack = _inventory.extractItem(slot, amount, false);

        _menu.slotsChanged(this);

        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate (int slot) {
        var stack = _inventory.getStackInSlot(slot);

        _inventory.setStackInSlot(slot, ItemStack.EMPTY);

        return stack;
    }

    @Override
    public void setItem (int slot, ItemStack stack) {
        _inventory.setStackInSlot(slot, stack);
        _menu.slotsChanged(this);
    }

    @Override
    public void setChanged () {}

    @Override
    public boolean stillValid (Player pPlayer) {
        return true;
    }

    @Override
    public void clearContent () {
        for (int i = 0; i < getContainerSize(); i++) {
            _inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }
}
