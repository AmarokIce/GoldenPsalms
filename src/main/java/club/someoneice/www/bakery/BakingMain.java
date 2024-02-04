package club.someoneice.www.bakery;

import club.someoneice.www.bakery.init.ItemInit;
import club.someoneice.www.bakery.item.ItemFoodHelper;
import club.someoneice.www.init.ItemList;
import club.someoneice.www.init.recipe.RecipePot;
import club.someoneice.www.util.WWWApi;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = BakingMain.MODID)
public class BakingMain {
    public static final String MODID = "baking_time";
    public static final CreativeTabs BAKING_TAB = new CreativeTabs(MODID) {
        @Override
        public Item getTabIconItem() {
            return itemFoodHelper;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public int func_151243_f() {
            return 2;
        }
    };

    public static Item itemFoodHelper;

    public static ItemStack getItemByBuilder(ItemFoodHelper.Builder builder) {
        return new ItemStack(itemFoodHelper, 1, ItemFoodHelper.items.indexOf(builder));
    }

    public static ItemStack getItemByBuilder(ItemFoodHelper.Builder builder, int size) {
        return new ItemStack(itemFoodHelper, size, ItemFoodHelper.items.indexOf(builder));
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ItemInit.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        itemFoodHelper = new ItemFoodHelper();
        addRecipe();
    }

    private static void addRecipe() {
        GameRegistry.addSmelting(Items.wheat, getItemByBuilder(ItemInit.HARD_BREAD), 0.5f);
        WWWApi.POT_MAP.add(new RecipePot(getItemByBuilder(ItemInit.LYE_BREAD), null, Items.wheat, Items.wheat, ItemList.salt));
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.BUM), " S ", "WWW", 'S', Items.sugar, 'W', Items.wheat);
        WWWApi.POT_MAP.add(new RecipePot(getItemByBuilder(ItemInit.BAKE_CHEESE), null, ItemList.toast, ItemList.cheese, ItemList.cheese, ItemList.tomato));
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.SUGAR_COOKIE, 8), "WSW", 'S', Items.sugar, 'W', Items.wheat);
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.SOFT_CAKE), "S S", "WEW", 'S', Items.sugar, 'W', Items.wheat, 'E', Items.egg);
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.WHEAT_CRACKER, 4), "W W", 'W', Items.wheat);
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.BAGEL), " W ", "W W", " W ", 'W', Items.wheat);
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.DONUT), " M ", "WSW", " W ", 'W', Items.wheat, 'M', Items.milk_bucket, 'S', Items.sugar);
        WWWApi.POT_MAP.add(new RecipePot(getItemByBuilder(ItemInit.EGG_TART, 2), null, Items.wheat, Items.wheat, Items.egg, Items.egg));
        WWWApi.POT_MAP.add(new RecipePot(getItemByBuilder(ItemInit.EGG_PUDDING), null, Items.milk_bucket, Items.egg, Items.egg));

        GameRegistry.addShapelessRecipe(getItemByBuilder(ItemInit.SWISS_ROLL), getItemByBuilder(ItemInit.SOFT_CAKE), Items.milk_bucket);
        GameRegistry.addShapelessRecipe(getItemByBuilder(ItemInit.BURGER), getItemByBuilder(ItemInit.BUM), Items.cooked_beef, ItemList.cut_tomato, ItemList.lettuce);
        GameRegistry.addShapelessRecipe(getItemByBuilder(ItemInit.SANDWICH), ItemList.toast, ItemList.toast, Items.cooked_chicken, ItemList.cut_tomato);
        GameRegistry.addShapelessRecipe(getItemByBuilder(ItemInit.HOTDOG), getItemByBuilder(ItemInit.BUM), Items.cooked_porkchop, ItemList.cut_tomato);
    }
}
