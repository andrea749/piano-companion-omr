package com.andrea.pianocompanionomr

import android.util.Log
import org.simpleframework.xml.core.Persister
import com.leff.midi.MidiFile
import com.leff.midi.MidiTrack
import com.leff.midi.event.NoteOn
import com.leff.midi.event.NoteOff
import com.andrea.pianocompanionomr.data.model.*
import java.io.InputStream

// TODO: return Song for storing in db
fun convertMusicXmlToMidi(xmlInputStream: InputStream) {
    val score = Persister().read(ScorePartwise::class.java, xmlInputStream)

    val tracks = mutableListOf<MidiTrack>()
    val noteTrack = MidiTrack()

    var tick = 0L
    for (part in score.part) {
        for (measure in part.measure) {
            for (note in measure.note) {
                note.pitch?.let {
                    val pitch = convertPitchToMidi(it)
                    val durationTicks = note.duration.toLong()

                    noteTrack.insertNoteOn(tick, 0, pitch, 100)
                    noteTrack.insertNoteOff(tick + durationTicks, 0, pitch, 100)
                    Log.d("andrea", "note: tick $tick pitch $pitch")
                    tick += durationTicks
                }
            }
        }
    }

    tracks.add(noteTrack)
    val midi = MidiFile(MidiFile.DEFAULT_RESOLUTION, tracks)
//    midi.writeToFile(File(midiFilePath))
}

private fun convertPitchToMidi(pitch: Pitch): Int {
    val stepToValue = mapOf("C" to 0, "D" to 2, "E" to 4, "F" to 5, "G" to 7, "A" to 9, "B" to 11)
    val basePitch = stepToValue[pitch.step.uppercase()]!! + (pitch.octave + 1) * 12
    val alter = pitch.alter ?: 0
    return basePitch + alter
}


private fun MidiTrack.insertNoteOn(tick: Long, channel: Int, key: Int, velocity: Int) {
    val noteOn = NoteOn(tick, channel, key, velocity)
    this.insertEvent(noteOn)
}

private fun MidiTrack.insertNoteOff(tick: Long, channel: Int, key: Int, velocity: Int) {
    val noteOff = NoteOff(tick, channel, key, velocity)
    this.insertEvent(noteOff)
}

