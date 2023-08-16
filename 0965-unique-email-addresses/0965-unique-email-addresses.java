class Solution{
    public int numUniqueEmails(String[] emails){
        int n = emails.length;
        HashSet<String> ans = new HashSet<>();
        for(int i=0; i<n; i++){
            String[] tmp = emails[i].split("@");
            StringBuilder a = new StringBuilder("");
            for(int j=0; j<tmp[0].length(); j++){
                if(tmp[0].charAt(j)=='+') break;
                if(tmp[0].charAt(j)!=46) a.append(tmp[0].charAt(j));
                
            }
            a.append('@');
            a.append(tmp[1]);
            ans.add(a.toString());
        }
        return ans.size();
    }
}