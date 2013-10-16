package dbnp.studycapturing

import java.io.Serializable;

class SubjectGroup implements Serializable{
	String name
	
	static hasMany = [ subjects: Subject ]
	static belongsTo = [ parent: Study ]
	
    static constraints = {
		// Ensure that the subjectgroup name is unique within the study
		name(unique: ['parent'])
    }
}
