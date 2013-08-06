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
}
