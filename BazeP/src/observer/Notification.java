package observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import observer.enums.NotificationCode;

@Data
@AllArgsConstructor
public class Notification {
	
	public Notification(NotificationCode code, Object data) {
		this.code=code;
		this.data=data;
	}
	
    private NotificationCode code;
    private Object data;
    
	public NotificationCode getCode() {
		return code;
	}
	public Object getData() {
		return data;
	}
    
    
}
