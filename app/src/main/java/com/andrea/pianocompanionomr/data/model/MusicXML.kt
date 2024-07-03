package com.andrea.pianocompanionomr.data.model

import org.simpleframework.xml.*

// Define data classes for MusicXML parsing
@Root(name = "score-partwise", strict = false)
data class ScorePartwise(
    @field:Attribute(name = "version", required = false) var version: String? = null,
    @field:Element(name = "work", required = false) var work: Work? = null,
    @field:Element(name = "identification", required = false) var identification: Identification? = null,
    @field:Element(name = "part-list", required = false) var partList: PartList? = null,
    @field:ElementList(inline = true) var part: List<Part> = mutableListOf()
)

@Root(name = "work", strict = false)
data class Work(
    @field:Element(name = "work-title", required = false) var workTitle: String? = null
)

@Root(name = "identification", strict = false)
data class Identification(
    @field:Element(name = "creator", required = false) var creator: Creator? = null
)

@Root(name = "creator", strict = false)
data class Creator(
    @field:Attribute(name = "type", required = false) var type: String? = null,
    @field:Text var value: String = ""
)

@Root(name = "part-list", strict = false)
data class PartList(
    @field:ElementList(inline = true) var scoreParts: List<ScorePart> = mutableListOf()
)

@Root(name = "score-part", strict = false)
data class ScorePart(
    @field:Attribute(name = "id") var id: String = "",
    @field:Element(name = "part-name") var partName: String = "",
    @field:ElementList(inline = true, required = false) var scoreInstruments: List<ScoreInstrument> = mutableListOf(),
    @field:ElementList(inline = true, required = false) var midiInstruments: List<MidiInstrument> = mutableListOf()
)

@Root(name = "score-instrument", strict = false)
data class ScoreInstrument(
    @field:Attribute(name = "id") var id: String = "",
    @field:Element(name = "instrument-name") var instrumentName: String = "",
    @field:Element(name = "instrument-sound", required = false) var instrumentSound: String? = null
)

@Root(name = "midi-instrument", strict = false)
data class MidiInstrument(
    @field:Attribute(name = "id") var id: String = "",
    @field:Element(name = "midi-channel", required = false) var midiChannel: Int? = null,
    @field:Element(name = "midi-program", required = false) var midiProgram: Int? = null,
    @field:Element(name = "volume", required = false) var volume: Double? = null,
    @field:Element(name = "pan", required = false) var pan: Double? = null
)

@Root(name = "part", strict = false)
data class Part(
    @field:Attribute(name = "id") var id: String = "",
    @field:ElementList(inline = true) var measure: List<Measure> = mutableListOf()
)

@Root(name = "measure", strict = false)
data class Measure(
    @field:Attribute(name = "number", required = false) var number: Int? = null,
    @field:Element(name = "attributes", required = false) var attributes: Attributes? = null,
    @field:ElementList(inline = true) var note: List<Note> = mutableListOf(),
    @field:ElementList(inline = true, required = false) var backup: List<Backup> = mutableListOf(),
    @field:Element(name = "sound", required = false) var sound: Sound? = null
)

@Root(name = "attributes", strict = false)
data class Attributes(
    @field:Element(name = "divisions", required = false) var divisions: Int? = null,
    @field:Element(name = "key", required = false) var key: Key? = null,
    @field:Element(name = "staves", required = false) var staves: Int? = null,
    @field:ElementList(inline = true, required = false) var clef: List<Clef> = mutableListOf()
)

@Root(name = "key", strict = false)
data class Key(
    @field:Element(name = "fifths", required = false) var fifths: Int? = null
)

@Root(name = "clef", strict = false)
data class Clef(
    @field:Attribute(name = "number", required = false) var number: Int? = null,
    @field:Element(name = "sign", required = false) var sign: String? = null,
    @field:Element(name = "line", required = false) var line: Int? = null
)

@Root(name = "note", strict = false)
data class Note(
    @field:Element(name = "pitch", required = false) var pitch: Pitch? = null,
    @field:Element(name = "duration", required = false) var duration: Int = 0,
    @field:Element(name = "type", required = false) var type: String? = null,
    @field:Element(name = "stem", required = false) var stem: String? = null,
    @field:Element(name = "staff", required = false) var staff: Int? = null,
    @field:Element(name = "voice", required = false) var voice: Int? = null,
    @field:Element(name = "dot", required = false) var dot: Dot? = null,
    @field:Element(name = "rest", required = false) var rest: Rest? = null
)

@Root(name = "pitch", strict = false)
data class Pitch(
    @field:Element var step: String = "",
    @field:Element var octave: Int = 0,
    @field:Element(required = false) var alter: Int? = null
)

@Root(name = "backup", strict = false)
data class Backup(
    @field:Element(name = "duration", required = false) var duration: Int? = null
)

@Root(name = "sound", strict = false)
data class Sound(
    @field:Attribute(name = "tempo", required = false) var tempo: Double? = null
)

@Root(name = "dot", strict = false)
data class Dot(
    @field:Text(required = false) var value: String? = null
)

@Root(name = "rest", strict = false)
data class Rest(
    @field:Attribute(name = "measure", required = false) var measure: Boolean? = null
)

