import java.util.Optional;
import java.lang.IllegalArgumentException;
import java.util.function.Function;

class Log<T> {

    private final T value;
    private final Optional<String> log;

    Log(T value) {
        this.value = value;
        this.log = Optional.empty();
    }

    Log(T value, String log) {
        this.value = value;;
        this.log = Optional.of(log);
    }

    Log(T value, Optional<String> log) {
        this.value = value;
        this.log = log;
    }

    //factory methods
    public static <T> Log<T> of(T value) {
        if (value instanceof Log l || value == null) {
            throw new IllegalArgumentException("Invalid arguments");
        } else {
            return new Log<T>(value);
        }
    }

/*  public static <T> Log<T> of(Log<T> value, String log) = del; //{ //C++ to get compiletime error
        throw new IllegalArgumentException("Invalid arguments");
    }
*/

    public static <T> Log<T> of(T value, String log) {
        Optional<String> optLog = Optional.ofNullable(log);
        Optional<T> optValue = Optional.ofNullable(value);
            
        return optValue
            .flatMap(x -> optLog.map(y -> new Log<T>(x, y)))
            .orElseThrow(() -> new IllegalArgumentException("Invalid arguments")); 
            //a method of Optional. 
            //If value is present, return it, otherwise throws an exception.  

/*        if (log == null) {
            throw new IllegalArgumentException("Invalid arguments");
        } else if (value == null) {
            throw new IllegalArgumentException("Invalid arguments");
        } else {
            return new Log<T>(value, log);
        }
*/
    }

    public void log() {
        log.ifPresent(x -> System.out.println(x));
        return;    
    }

    public String toString() {
        return "Log[" + this.value + "]";
    }
    

    public <R> Log<R> map(Function<? super T, ? extends R> mapper) {
        return new Log<R>(mapper.apply(this.value), this.log);

    }

    public <R> Log<R> flatMap(Function<? super T, ? extends Log<? extends R>> flatMapper) {
        Log<? extends R> result = flatMapper.apply(this.value);
        

        /*
        Log<? extends R> result = flatMapper.apply(this.value);
        return Log<R>.of(result.value, this.log);
        */
    }
}
