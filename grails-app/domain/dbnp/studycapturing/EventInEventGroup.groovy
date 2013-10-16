package dbnp.studycapturing

class EventInEventGroup implements Serializable {
	Event 		event
    EventGroup 	eventGroup
	
	/**
	 * Relative time of the event within the eventgroup
	 */
	long startTime
	
	/** 
	 * duration of the event
	 */
	long duration

	
	static belongsTo = [ Event, EventGroup ]
	
	static constraints = {
		duration(default: 0L)
    }
}
