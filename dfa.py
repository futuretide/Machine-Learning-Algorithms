class Solution:
    def isNumber(self, s: str) -> bool:
        keymap = {}
        
        for i in string.digits:
            keymap[i] = "digit"
        for i in ["+", "-"]:
            keymap[i] = "sign"
        for i in ["."]:
            keymap[i] = "dot"
        for i in ["e", "E"]:
            keymap[i] = "exp"
        
        dfa = {
            0 : { # rejected
                "sign": 0,
                "exp": 0,
                "digit": 0,
                "eof": 0,
                "dot": 0            
            },
            1: { # accepted
                "sign": 1,
                "exp": 1,
                "digit": 1,
                "eof": 1,
                "dot": 1
            },
            2: { # start
                "sign": 3,
                "exp": 0,
                "digit": 4,
                "eof": 0,
                "dot": 5                
            },
            3: { # seen a sign
                "sign": 0,
                "exp": 0,
                "digit": 4, # seen a digit, not a dot
                "eof": 0,
                "dot": 5 # seen a dot, not a digit
            }, 
            4: { # seen a digit, not a dot
                "sign": 0,
                "exp": 7,
                "digit": 4,
                "eof": 1,
                "dot": 6  # seen digits, seen a dot         
            },
            5: {  # seen a dot, not a digit
                "sign": 0,
                "exp": 0,
                "digit": 6,
                "eof": 0,
                "dot": 0                     
            },
            6: { # seen digits, seen a dot
                "sign": 0,
                "exp": 7,
                "digit": 6,
                "eof": 1,
                "dot": 0                  
            },
            7: { # seen exp
                "sign": 8, # seen exp, seen sign
                "exp": 0,
                "digit": 9, # seen exp, seen digit
                "eof": 0,
                "dot": 0 
            },
            8: { # seen exp, seen sign
                "sign": 0,
                "exp": 0,
                "digit": 9, 
                "eof": 0,
                "dot": 0                 
            },
            9: { # seen exp, seen digit
                "sign": 0, 
                "exp": 0,
                "digit": 9,
                "eof": 1,
                "dot": 0                    
            }
        }
        
      def accepts(transitions,initial,accepting,s):
            try:
                state = initial
                for c in s:
                    state = transitions[state][keymap[c]]
                state = transitions[state]["eof"]
                return state in accepting
            except KeyError:
                return False

        return accepts(
            dfa,
            2,
            [1],
            s
        )        
