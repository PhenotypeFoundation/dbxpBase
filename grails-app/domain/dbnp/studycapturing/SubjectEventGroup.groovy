package dbnp.studycapturing

class SubjectEventGroup {
	SubjectGroup subjectGroup
	EventGroup eventGroup
	
	/** 
	 * Start time of the eventgroup for this group of subjects, 
	 * relative to the start time of the study as the number of seconds
	 */
	long startTime
	
	/**
	 * Returns the absolute start date for this event group
	 * @return
	 */
	public Date getStartDate() {
		Calendar calendar = Calendar.getInstance();
		
		// Add the startTime to the startdate of the study
		calendar.setTime(parent.startDate);
		calendar.add( Calendar.SECOND, (int) startTime )
		
		calendar.time
	}
	
	/**
	 * Returns the absolute end date for this event group
	 * @return
	 */
	public Date getEndDate() {
		Calendar calendar = Calendar.getInstance();
		
		// Add the startTime and the duration of the eventgroup to the startdate of the study
		calendar.setTime(parent.startDate);
		calendar.add( Calendar.SECOND, (int) startTime + (int) eventGroup?.duration?.value )
		
		calendar.time
	}
	
	static belongsTo = [ parent: Study ]
	
	static constraints = {
    }
}
