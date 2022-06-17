package me.tud.diskuise.util.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import me.libraryaddict.disguise.disguisetypes.Disguise;

public abstract class DisguisePropertyExpression<T> extends SimplePropertyExpression<Disguise, T> {

    public static <T> void register(final Class<? extends Expression<T>> c, final Class<T> type, final String property) {
        Skript.registerExpression(c, type, ExpressionType.PROPERTY, "[the] " + property + " of [dis(g|k)uise] %disguises%",
                "[dis(g|k)uise] %disguises%'[s] " + property);
    }

}
