package dbnp.studycapturing

class SubjectEventGroup {
	SubjectGroup subjectGroup
	EventGroup eventGroup
	
	/** 
	 * Start time of the eventgroup for this group of subjects, 
	 * relative to the start time of the study 
	 */
	long startTime
	
	static belongsTo = [ parent: Study ]
	
	static constraints = {
    }
}
