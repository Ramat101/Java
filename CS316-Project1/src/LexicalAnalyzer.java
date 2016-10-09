/**
 This class is a lexical analyzer that implements a DFA that accepts tokens defined by the following grammar:

<functor> --> <lowercase letter> { <letter> | <digit> }
<var> --> <uppercase letter> { <letter> | <digit> }
<letter> --> <lowercase letter> | <uppercase letter>
<lowercase letter> --> a | b | ... | z
<uppercase letter> --> A | B | ... | Z
<int> --> [+|-] { <digit> }+
<floatE> --> <float> (E|e) [+|-] { <digit> }+
<float> --> [+|-] ({ <digit> }+ "." { <digit> } | "." { <digit> }+
<digit> --> 0 | 1 | ... | 9
<if> --> ":-"
<add> --> +
<sub> --> -
<mul> --> *
<div> --> /
<lt> --> "<"
<le> --> "=<"
<gt> --> ">"
<ge> --> ">="
<eq> --> "="
<neq> --> "\="
<LParen> --> "("
<RParen> --> ")"
<LBracket> --> "["
<RBracket> --> "]"
<bar> --> "|"
<comma> --> ","
<period> --> "."

The DFA states are represented by the Enum type "State".

The DFA has the following 23 final states represented by enum-type literals:
(State: Token accepted)
FUNCTOR: function title
VAR: variable name
INT: integer
FLOAT: floats without exponentiation part
FLOAT_E: floats with exponentiation part
IF: :-
ADD: +
SUB: -
MUL: *
DIV: /
LT: <
LE: =<
GT: >
GE: >=
EQ: =
NEQ: \=
L_PAREN: (
R_PAREN: )
L_BRACKET: [
R_BRACKET: ]
BAR: |
COMMA: , 
PERIOD: .

The DFA also uses the following 6 non-final states:
(State: string recognized)
START: the empty string
BACKSLASH: \
ADD_SUB_PERIOD: float part starting with a + or - (a float without a leading integer)
COLON: :
E: the exponent indicator for a floatE
E_PLUS_MINUS: an optional + or - for a floatE

**/

public class LexicalAnalyzer extends IO{
	
	public LexicalAnalyzer(String inFile, String outFile) {
		super(inFile, outFile);
	}

	//DFA states
	public enum State { 
		//non-final states: ordinal number
		START,			// 0
		BACKSLASH,      // 1
		ADD_SUB_PERIOD, // 2
		COLON,        	// 3
		E,				// 4
		E_PLUS_MINUS,	// 5

		//final states: ordinal number
		FUNCTOR,		// 6
		VAR,			// 7	
		INT,			// 8
		FLOAT,			// 9
		FLOAT_E,		// 10
		IF,				// 11
		ADD,			// 12
		SUB,			// 13
		MUL,			// 14
		DIV,			// 15
		LT,				// 16
		LE,				// 17
		GT,				// 18
		GE,				// 19
		EQ,				// 20
		NEQ,			// 21
		L_PAREN,		// 22
		R_PAREN,		// 23
		L_BRACKET,		// 24
		R_BRACKET,		// 25
		BAR,			// 26
		COMMA, 			// 27
		PERIOD,			// 28
		
		UNDEF;			// 29
		
		//determines if the state is a final state or not
		//if the ordinal number of the enum is >= the ordinal number of state FUNCTOR then the state is a final state
		private boolean isFinal(){
			return ( this.compareTo(State.FUNCTOR) >= 0 );  
		}	
	}

	public static String t; // holds an extracted token
	public static State state; // holds the current state of the DFA

	// This is the driver of the DFA. Tokens are assigned to "t". 
	// Returns 1 if token is valid, 0 if token is invalid, and -1 if end-of-stream is reached without finding any non-whitespace characters.
	public static int driver(){
		State nextState; // the next state of the DFA
		t = "";
		state = State.START;

		//skip any white-space characters
		if (Character.isWhitespace((char) inputInt)){
			inputInt = getChar(); // get the next non-whitespace character
		}
		// are we at the end of the stream?
		if ( inputInt == -1 ){ 
			return -1;
		}
		
		// continue until we get to the end of the stream
		while ( inputInt != -1 ){
			c = (char)inputInt;
			
			//move to the next state
			nextState = nextState( state, c );
			
			//is the new state undefined?
			if ( nextState == State.UNDEF ){ 
				// if the next state is undefined, then the DFA will halt
				if ( state.isFinal() )
					return 1; // valid token extracted
				else{ // "c" is an unexpected character
					t = t+c;
					inputInt = getNextChar();
					return 0; // invalid token found
				}
			}
			
			// new state is valid
			else {
				state = nextState;	//move to the next state
				t = t+c;	//add c to the token
				inputInt = getNextChar();	//get next character in the input stream
			}
		}

		// end-of-stream is reached while a token is being extracted
		if ( state.isFinal() )
			return 1; // valid token extracted
		else
			return 0; // invalid token found
	} // end driver

	// Extract the next token using the driver of the DFA.
	public static void getToken(){
		int i = driver();	//get the result of th driver funtion
		if ( i == 1 )
			println( t+" : "+state.toString() );
		else if ( i == 0 )
			println( t+" : Lexical Error, invalid token");
	}

	// Returns the next state of the DFA, if the next state is undefined then state UNDEF is returned
	private static State nextState(State s, char c){
		switch( state ){
		
		// start state of the DFA
		case START:
			if ( Character.isLowerCase(c) )
				return State.FUNCTOR;
			else if (Character.isUpperCase(c))
				return State.VAR;
			else if ( Character.isDigit(c) )
				return State.INT;
			else if ( c == '+' )
				return State.ADD;
			else if ( c == '-' )
				return State.SUB;
			else if ( c == '*' )
				return State.MUL;
			else if ( c == '/' )
				return State.DIV;
			else if ( c == '<' )
				return State.LT;
			else if ( c == '>' )
				return State.GT;
			else if ( c == '=' )
				return State.EQ;
			else if ( c == '\\')
				return State.BACKSLASH;
			else if ( c == '(' )
				return State.L_PAREN;
			else if ( c == ')' )
				return State.R_PAREN;
			else if ( c == '[' )
				return State.L_BRACKET;
			else if ( c == ']' )
				return State.R_BRACKET;
			else if ( c == '|' )
				return State.BAR;
			else if ( c == ',' )
				return State.COMMA;
			else if ( c == '.' )
				return State.PERIOD;
			else if ( c == ':')
				return State.COLON;
			else
				return State.UNDEF;
			
		case FUNCTOR:
			if ( Character.isLetterOrDigit(c) )
				return State.FUNCTOR;
			else
				return State.UNDEF;
			
		case VAR:
			if ( Character.isLetterOrDigit(c) )
				return State.VAR;
			else
				return State.UNDEF;
			
		case INT:
			if ( Character.isDigit(c) )
				return State.INT;
			else if ( c == '.')
				return State.FLOAT;
			else
				return State.UNDEF;
			
		case FLOAT:
			if ( Character.isDigit(c) )
				return State.FLOAT;
			else if ( c == 'e' || c == 'E' )
				return State.E;
			else
				return State.UNDEF;
			
		case E:
			if ( Character.isDigit(c) )
				return State.FLOAT_E;
			else if ( c == '+' || c == '-' )
				return State.E_PLUS_MINUS;
			else
				return State.UNDEF;
			
		case E_PLUS_MINUS:
			if ( Character.isDigit(c) )
				return State.FLOAT_E;
			else
				return State.UNDEF;
			
		case FLOAT_E:
			if ( Character.isDigit(c) )
				return State.FLOAT_E;
			else
				return State.UNDEF;
			
		case ADD:
			if( Character.isDigit(c) )
				return State.INT;
			else if ( c == '.')
				return State.ADD_SUB_PERIOD;
			else
				return State.UNDEF;
		
		case ADD_SUB_PERIOD:
			if( Character.isDigit(c) )
				return State.FLOAT;
			else
				return State.UNDEF;
		
		case SUB:
			if( Character.isDigit(c) )
				return State.INT;
			else if ( c == '.' )
				return State.ADD_SUB_PERIOD;
			else
				return State.UNDEF;
			
		case PERIOD: 
			if( Character.isDigit(c) )
				return State.FLOAT;
			else
				return State.UNDEF;
			
		case COLON: 
			if( c == '-')
				return State.IF;
			else
				return State.UNDEF;
			
		case GT:
			if( c == '=')
				return State.GE;
			else
				return State.UNDEF;
			
		case EQ:
			if ( c == '<')
				return State.LE;
			else
				return State.UNDEF;
		
		case BACKSLASH: 
			if ( c == '=' )
				return State.NEQ;
			else
				return State.UNDEF;
			
		default:
			return State.UNDEF;
		}
	} // end nextState
} 
