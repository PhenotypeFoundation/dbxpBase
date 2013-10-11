package dbnp.studycapturing
import org.dbnp.gdt.*

/**
 * EventGroup groups events
 *
 * Revision information:
 * $Rev$
 * $Author$
 * $Date$
 */
class EventGroup extends Identity {
	String name

	static belongsTo = [parent : Study]
	static hasMany = [
		eventInstances: EventInEventGroup,
		samplingEventInstances: SamplingEventInEventGroup
	]

	static constraints = {
		// Ensure that the event group name is unique within the study
		name(unique:['parent'])
	}
	
	
	/**
	 * Get the duration of the event as RelTime
	 * @return RelTime
	 */
	def getDuration() {
		// Determine the maximum startTime + duration 
		def duration = 0
		(eventInstances + samplingEventInstances).findAll().each {
			def endTime = it.startTime + it.duration 
			if( endTime > duration )
				duration = endTime; 
		}
		
		return new RelTime(duration)
	}
	
	def getContents() {
		return ""
	}

}
