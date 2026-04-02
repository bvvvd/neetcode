class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> simplifiedPath = new LinkedList<>();
        for (String token: path.split("/")) {
            if (!token.isBlank() && !token.equals(".")) {
                if (token.equals("..")) {
                    if (!simplifiedPath.isEmpty()) {
                        simplifiedPath.removeLast();
                    }
                } else {
                    simplifiedPath.add(token);
                }
            }
        }

        return "/" + (simplifiedPath.isEmpty() ? "" : String.join("/", simplifiedPath));
    }
}