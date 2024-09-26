package ir.meisammohamadi.first_mvc_project.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA.
 * User: meisam Mohamadi
 
 */

public class RegularExpression {
    private Pattern pattern;
    private Matcher matcher;

    private  final String USERNAME_PATTERN = "^[a-z0-9_-]{6,15}$";
    /*
    ^                     # Start of the line
    [a-z0-9_-]	          # Match characters and symbols in the list, a-z, 0-9, underscore, hyphen
    {6,15}                # Length at least 6 characters and maximum length of 15
    $                     # End of the line
    */
    private  final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{10,25})";
    /*
        (		    	    # Start of group
        (?=.*\d)		    #   must contains one digit from 0-9
        (?=.*[a-z])	    	#   must contains one lowercase characters
        (?=.*[A-Z])	    	#   must contains one uppercase characters
        (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
        .		            #     match anything with previous condition checking
        {6,20}	            #        length at least 6 characters and maximum of 20
        )		        	# End of group
     */


   
    private  final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    /*
        ^		        	#start of the line
        [_A-Za-z0-9-\\+]+	#  must start with string in the bracket [ ], must contains one or more (+)
        (			        #   start of group #1
        \\.[_A-Za-z0-9-]+	#     follow by a dot "." and string in the bracket [ ], must contains one or more (+)
        )*		        	#   end of group #1, this group is optional (*)
        @		        	#     must contains a "@" symbol
        [A-Za-z0-9-]+       #       follow by string in the bracket [ ], must contains one or more (+)
        (		        	#         start of group #2 - first level TLD checking
        \\.[A-Za-z0-9]+     #           follow by a dot "." and string in the bracket [ ], must contains one or more (+)
        )*		            #         end of group #2, this group is optional (*)
        (			        #         start of group #3 - second level TLD checking
        \\.[A-Za-z]{2,}     #           follow by a dot "." and string in the bracket [ ], with minimum length of 2
        )			        #         end of group #3
        $			        #end of the line
     */
   
   



    public boolean validateEmail( String email) {

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public boolean validatePassword( String password) {

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }
    public boolean validateUsername( String username) {

        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);
        return matcher.matches();

    }
}
