package ru.job4j.collection.analize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.getId(), user.getName());
        }
        for (User currentUser : current) {
            if (previousMap.get(currentUser.getId()) == null) {
                info.added++;
            } else if (!currentUser.getName().equals(previousMap.get(currentUser.getId()))) {
                info.changed++;
            }
            previousMap.remove(currentUser.getId());
        }
        info.deleted = previousMap.size();
        return info;
    }

    public static class Info {

        private int added = 0;
        private int changed = 0;
        private int deleted = 0;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }

}
