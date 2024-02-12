package club.someoneice.www.bakery;

import club.someoneice.www.init.BlockList;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = GoldenPsalms.MODID, name = GoldenPsalms.NAME)
public class GoldenPsalms {
    public static final String MODID = "golden_psalms";
    public static final String NAME = "Golden Psalms";


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
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.LYE_BREAD), null, Items.wheat, Items.wheat, ItemList.salt));
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.BUM), " S ", "WWW", 'S', Items.sugar, 'W', Items.wheat);
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.BAKE_CHEESE), null, ItemList.toast, ItemList.cheese, ItemList.cheese, ItemList.tomato));
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.SUGAR_COOKIE, 8), "WSW", 'S', Items.sugar, 'W', Items.wheat);
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.SOFT_CAKE), "S S", "WEW", 'S', Items.sugar, 'W', Items.wheat, 'E', Items.egg);
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.WHEAT_CRACKER), "W W", 'W', ItemList.cornmeal);
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.BAGEL), " W ", "W W", " W ", 'W', Items.wheat);
        GameRegistry.addShapedRecipe(getItemByBuilder(ItemInit.DONUT), " M ", "WSW", " W ", 'W', Items.wheat, 'M', Items.milk_bucket, 'S', Items.sugar);
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.EGG_TART, 2), null, Items.wheat, Items.wheat, Items.egg, Items.egg));
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.EGG_PUDDING), null, Items.milk_bucket, Items.egg, Items.egg));

        GameRegistry.addShapelessRecipe(getItemByBuilder(ItemInit.SWISS_ROLL), getItemByBuilder(ItemInit.SOFT_CAKE), Items.milk_bucket);
        WWWApi.CUT_RECIPES.put(new ItemStack(Blocks.cake), getItemByBuilder(ItemInit.SMALL_CAKE, 5));
        GameRegistry.addShapelessRecipe(getItemByBuilder(ItemInit.BURGER), getItemByBuilder(ItemInit.BUM), ItemList.cooked_meat_stuffing, ItemList.cut_tomato, ItemList.lettuce, ItemList.cheese);
        GameRegistry.addShapelessRecipe(getItemByBuilder(ItemInit.SANDWICH), ItemList.toast, ItemList.toast, ItemList.cooked_bacon, ItemList.cut_tomato, ItemList.cheese);
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.HOTDOG), getItemByBuilder(ItemInit.BUM), Items.cooked_porkchop, ItemList.cut_tomato, ItemList.butter));

        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.BEER), new ItemStack(Items.glass_bottle), Items.wheat, Items.wheat, Items.potionitem));
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.SAUCE_WING), new ItemStack(Items.glass_bottle), Items.wheat_seeds, Items.wheat_seeds, Items.wheat, Items.wheat, Items.potionitem));
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.MOONLIGHT), new ItemStack(Items.glass_bottle), Items.wheat_seeds, Items.wheat, Items.wheat, Items.wheat, Items.sugar, Items.potionitem));
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.WHEAT_MILK_TEA), new ItemStack(Items.glass_bottle), Items.wheat, Items.wheat, Items.milk_bucket, Items.sugar));

        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.RICE), new ItemStack(Items.bowl), new ItemStack(BlockList.rice), new ItemStack(BlockList.rice)));
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.RICE_WINE), new ItemStack(Items.glass_bottle), getItemByBuilder(ItemInit.RICE), getItemByBuilder(ItemInit.RICE), new ItemStack(Items.water_bucket), new ItemStack(Items.sugar), new ItemStack(Items.sugar)));
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.RICE_BALL), null,  getItemByBuilder(ItemInit.RICE), getItemByBuilder(ItemInit.RICE), new ItemStack(Items.sugar)));
        WWWApi.POT_RECIPES.add(new RecipePot(getItemByBuilder(ItemInit.RICE_MILK_SHAKE), new ItemStack(Items.glass_bottle), getItemByBuilder(ItemInit.RICE), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar)));
    }
}
