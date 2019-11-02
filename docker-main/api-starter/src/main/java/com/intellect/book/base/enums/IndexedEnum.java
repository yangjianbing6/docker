package com.intellect.book.base.enums;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public interface IndexedEnum {


    int getCode();

    String getName();

    final class IndexedEnumUtil {

        private IndexedEnumUtil() {

        }

        public static <E extends IndexedEnum> List<E> toIndexes(E[] enums) {
            int maxIndex = Integer.MIN_VALUE;
            int curIdx = 0;
            for (E enm : enums) {
                curIdx = enm.getCode();
                Preconditions.checkArgument(curIdx >= 0, "The index of Enum[%s] must be >= 0.", enm);
                if (curIdx > maxIndex) {
                    maxIndex = curIdx;
                }
            }
            List<E> instances = new ArrayList<E>(maxIndex + 1);
            for (int i = 0; i < maxIndex + 1; i++) {
                instances.add(null);
            }
            for (E enm : enums) {
                curIdx = enm.getCode();
                Preconditions.checkState(instances.get(curIdx) == null,
                        "The index of Enum[%s] is not unique.", enums.getClass().getComponentType().getName());
                instances.set(curIdx, enm);
            }
            return instances;
        }

        public static <E extends IndexedEnum> E valueOf(List<E> values, int index) {
            if (index < 0 || index >= values.size()) {
                return null;
            }
            return values.get(index);
        }
    }

}
