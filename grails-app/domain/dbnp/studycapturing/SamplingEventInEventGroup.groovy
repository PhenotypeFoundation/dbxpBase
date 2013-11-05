package dbnp.studycapturing

import java.io.Serializable;

class SamplingEventInEventGroup implements Serializable{
	SamplingEvent 	event
    EventGroup 		eventGroup
	
	/**
	 * Relative time of the samplingevent within the eventgroup
	 */
	long startTime
	
	/** Duration of the sampling event, if it has any (default is 0) */
	long duration
	
	
	/**
	 * Sets the startTime from an absolute date (number of seconds since 1970)
	 */
	public void setAbsoluteStartTime( Number seconds ) {
		startTime = seconds - eventGroup.parent.startDate.time / 1000
	}
	
	static belongsTo = [ SamplingEvent, EventGroup ]
	static hasMany = [ samples : Sample ]
	
	static constraints = {
		duration(default: 0L)
    }
}
