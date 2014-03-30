Grand Rounds Auto
Present Grand Rounds and quiz your colleagues and residents.
While you present each case, attendees can guess what they think the diagnosis is.
The first one to guess the correct diagnosis wins!



Home
	* Present -> CreatePresentation
	* Attend -> SelectPresentation

CreatePresentation
	[ Presentation Title ]
	[ Name ]
	[ Email ]
	( Continue ) -> AddCases

AddCases
	[ Case Description ] [ Final Diagnosis ] ( x )
	cases can be reordered by dragging
	( Add another case )
	( I'm Done ) -> PresentationStarter

PresentationStarter
	Presentation Title
	Attendees (added as they join)
	( Begin Presentation ) -> PresentCase

PresentCase
	Case #n
	Case Title
	( Reveal diagnosis ) -> Confirm -> PresentCase_revealed

PresentCase_revealed
if no exact match:
	Case #n
	Case Title
	Select the correct Diagnosis
	- list of diagnoses submitted -> PresentCase_award
	( Correct diagnosis was not submitted ) -> PresentCase_award
else:
	goto PresentCase_award

PresentCase_award
	Case #n
	Case Title
	Correct Diagnosis
	Winner: Attendee_Name
	Time: Timestamp
	if more cases:
		( Present Next Case ) -> PresentCase
	else:
		( End Grand Rounds ) -> PresentationStarter

SelectPresentation
	* list of presentations: name, presenter -> JoinPresentation

JoinPresentation
	if presentation has not yet started:
		Waiting for Presenter...
	else:
		go to AttendCase

AttendCase
	Case #n
	Case description
	[ Your Diagnosis ]
	( Submit ) -> AttendCase_submitted

AttendCase_submitted
	Case #n
	Case description
	Final Diagnosis: ( revealed when presenter reveals)
	Your Diagnosis: Their diagnosis
	Time to diagnosis: 3:28
	Attendee diagnosis | Attendee name | Timestamp (since case presentation started)
	their name is highlighted in red










