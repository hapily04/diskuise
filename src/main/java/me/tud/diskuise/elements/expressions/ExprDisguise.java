package me.tud.diskuise.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.tud.diskuise.elements.sections.ExprSecCreateDisguise;
import me.tud.diskuise.util.DisguiseUtils;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

@NoDoc
public class ExprDisguise extends SimpleExpression<Disguise> {

    static {
        Skript.registerExpression(ExprDisguise.class, Disguise.class, ExpressionType.SIMPLE, "[the] dis(g|k)uise");
    }

    @Override
    protected @Nullable Disguise[] get(Event e) {
        return new Disguise[]{DisguiseUtils.getLastCreatedDisguise()};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Disguise> getReturnType() {
        return Disguise.class;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "disguise";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        return getParser().isCurrentSection(ExprSecCreateDisguise.class);
    }
}
