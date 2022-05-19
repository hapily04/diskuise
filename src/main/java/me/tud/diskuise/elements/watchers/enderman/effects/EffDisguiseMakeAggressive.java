package me.tud.diskuise.elements.watchers.enderman.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.libraryaddict.disguise.disguisetypes.watchers.EndermanWatcher;
import me.tud.diskuise.utils.DisguiseUtil;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

@Name("Enderman Disguise - Make Aggressive")
@Description("Sets if an enderman disguise appears to be aggressive")
@Examples({"make player's disguise aggressive"})
@Since("0.2-beta3")
@RequiredPlugins({"LibsDisguises"})
public class EffDisguiseMakeAggressive extends Effect {

    static {
        Skript.registerEffect(EffDisguiseMakeAggressive.class,
                "make [dis(k|g)uise] %disguise% [1¦not] aggressive");
    }

    Expression<Disguise> disguise;
    boolean bool;

    @Override
    protected void execute(Event e) {
        Disguise disguise = this.disguise.getSingle(e);
        if (disguise == null) return;
        EndermanWatcher watcher;
        try {
            watcher = (EndermanWatcher) disguise.getWatcher();
        } catch (ClassCastException ignore) { return; }
        watcher.setAggressive(bool);
        DisguiseUtil.update(disguise);
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        disguise = (Expression<Disguise>) exprs[0];
        bool = parseResult.mark != 1;
        return true;
    }
}
