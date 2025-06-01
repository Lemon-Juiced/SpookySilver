package dev.lemonjuice.spooky_silver;

import dev.lemonjuice.spooky_silver.block.SSBlocks;
import dev.lemonjuice.spooky_silver.creativetab.SSCreativeTab;
import dev.lemonjuice.spooky_silver.item.SSItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(SpookySilver.MODID)
public class SpookySilver {
    public static final String MODID = "spooky_silver";

    public SpookySilver(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register Items & Blocks
        SSItems.register(modEventBus);
        SSBlocks.register(modEventBus);

        // Register Creative Tab
        SSCreativeTab.register(modEventBus);
        modEventBus.addListener(SSCreativeTab::registerTabs);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    public static ResourceLocation makeID(String ID) {
        return ResourceLocation.fromNamespaceAndPath(MODID, ID);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
