package ch07;

import java.util.Comparator;

public class Item42 {

    /*
     *    L0
     *     LINENUMBER 8 L0
     *     NEW ch07/Item42$1
     *     DUP
     *     ALOAD 0
     *     INVOKESPECIAL ch07/Item42$1.<init> (Lch07/Item42;)V
     *     ARETURN
     *    L1
     *     LOCALVARIABLE this Lch07/Item42; L0 L1 0
     *     MAXSTACK = 3
     *     MAXLOCALS = 1
     */
    Comparator<String> anonymousClass() {
        return new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                return Integer.compare(left.length(), right.length());
            }
        };
    }

    /*
     *    L0
     *     LINENUMBER 17 L0
     *     INVOKEDYNAMIC compare()Ljava/util/Comparator; [
     *       // handle kind 0x6 : INVOKESTATIC
     *       java/lang/invoke/LambdaMetafactory.metafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
     *       // arguments:
     *       (Ljava/lang/Object;Ljava/lang/Object;)I,
     *       // handle kind 0x6 : INVOKESTATIC
     *       ch07/Item42.lambda$lambda$0(Ljava/lang/String;Ljava/lang/String;)I,
     *       (Ljava/lang/String;Ljava/lang/String;)I
     *     ]
     *     ARETURN
     *    L1
     *     LOCALVARIABLE this Lch07/Item42; L0 L1 0
     *     MAXSTACK = 1
     *     MAXLOCALS = 1
     */
    Comparator<String> lambda() {
        return (left, right) -> Integer.compare(left.length(), right.length());
    }

    /*
     *    L0
     *     LINENUMBER 21 L0
     *     INVOKEDYNAMIC applyAsInt()Ljava/util/function/ToIntFunction; [
     *       // handle kind 0x6 : INVOKESTATIC
     *       java/lang/invoke/LambdaMetafactory.metafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
     *       // arguments:
     *       (Ljava/lang/Object;)I,
     *       // handle kind 0x5 : INVOKEVIRTUAL
     *       java/lang/String.length()I,
     *       (Ljava/lang/String;)I
     *     ]
     *     INVOKESTATIC java/util/Comparator.comparingInt (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
     *     ARETURN
     *    L1
     *     LOCALVARIABLE this Lch07/Item42; L0 L1 0
     *     MAXSTACK = 1
     *     MAXLOCALS = 1
     */
    Comparator<String> lambdaReference() {
        return Comparator.comparingInt(String::length);
    }
}
