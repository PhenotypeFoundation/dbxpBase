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
		samplingEventInstances: SamplingEventInEventGroup,
		subjectEventGroups: SubjectEventGroup
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
		def lastEndTime = 0
		def start = 0
		(eventInstances + samplingEventInstances).findAll().each {
			if( it.startTime < start && it.startTime >= 0 )
				start = it.startTime
				
			def endTime = it.startTime + it.duration 
			if( endTime > lastEndTime )
				lastEndTime = endTime; 
		}
		
		return new RelTime(lastEndTime - start)
	}
	
	def getContents() {
		return ""
	}

}
