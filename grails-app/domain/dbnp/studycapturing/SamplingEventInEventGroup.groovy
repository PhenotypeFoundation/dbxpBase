package dbnp.studycapturing

class SamplingEventInEventGroup {
	SamplingEvent 	event
    EventGroup 		eventGroup
	
	/**
	 * Relative time of the samplingevent within the eventgroup
	 */
	long startTime
	
	/** Duration of the sampling event, if it has any (default is 0) */
	long duration
	
	static belongsTo = [ SamplingEvent, EventGroup ]
	
	static constraints = {
		duration(default: 0L)
    }
}
