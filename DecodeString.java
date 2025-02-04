//TC = O(k*k*k)
//SC = O(k*k*k)
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        Integer currNum = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum = currNum*10 + (c - '0');
            }
            else if(c == '[')
            {
                strSt.push(currStr);
                numSt.push(currNum);

                //baby has started
                currNum = 0;
                currStr = new StringBuilder();
            }

            else if(c == ']')
            {
                StringBuilder decodedBaby = new StringBuilder();
                int k = numSt.pop();
                for(int j = 0; j < k; j++)
                {
                    decodedBaby.append(currStr);
                }

                //appedn it with parent
                StringBuilder parent = strSt.pop();
                currStr = parent.append(decodedBaby);
                 
            }
            else //its character
            {
                currStr.append(c);
            }

        }
        return currStr.toString();
    }
}