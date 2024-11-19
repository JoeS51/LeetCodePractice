class Solution {

    Map<String, List<String>> adjMap = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        

        for (List<String> emails : accounts) {
            String firstMail = emails.get(1);
            for (int i = 2; i < emails.size(); i++) {
                String currMail = emails.get(i);
                if (!adjMap.containsKey(firstMail)) {
                    adjMap.put(firstMail, new ArrayList<>());
                }
                adjMap.get(firstMail).add(currMail);
                if (!adjMap.containsKey(currMail)) {
                    adjMap.put(currMail, new ArrayList<>());
                }
                adjMap.get(currMail).add(firstMail);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();

        for (List<String> emails : accounts) {
            String name = emails.get(0);
            String firstMail = emails.get(1);
            if (!visited.contains(firstMail)) {
                List<String> newAccount = new ArrayList<>();

                dfs(firstMail, newAccount);

                
                Collections.sort(newAccount);
                newAccount.add(0, name);
                mergedAccounts.add(newAccount);
            }
        }
        return mergedAccounts;
    }

    private void dfs(String mail, List<String> account) {
        if (visited.contains(mail)) return;
        visited.add(mail);
        account.add(mail);
        if (!adjMap.containsKey(mail)) return;
        List<String> mails = adjMap.get(mail);
        for (int i = 0; i < mails.size(); i++) {
            dfs(mails.get(i), account);
        }
    }
}