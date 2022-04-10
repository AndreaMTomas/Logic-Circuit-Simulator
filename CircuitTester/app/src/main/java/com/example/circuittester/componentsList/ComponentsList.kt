package com.example.circuittester.componentsList

import android.content.res.Resources
import com.example.circuittester.R
import com.example.circuittester.data.Component

fun componentsList(resources: Resources): List<Component>{
    return listOf(
        Component(
            id = 0,
            name = resources.getString(R.string.not_gate_name),
            title = resources.getString(R.string.not_title),
            description = resources.getString(R.string.not_gate_description),
            icon = R.drawable.not,
            truthTable = R.drawable.not_truth_table
        ),
        Component(
            id = 1,
            name = resources.getString(R.string.and_gate_name),
            title = resources.getString(R.string.and_title),
            description = resources.getString(R.string.and_gate_description),
            icon = R.drawable.and,
            truthTable = R.drawable.and_truth_table
        ),
        Component(
            id = 2,
            name = resources.getString(R.string.or_gate_name),
            title = resources.getString(R.string.or_title),
            description = resources.getString(R.string.or_gate_description),
            icon = R.drawable.or,
            truthTable = R.drawable.or_truth_table
        ),
        Component(
            id = 3,
            name = resources.getString(R.string.xor_gate_name),
            title = resources.getString(R.string.xor_title),
            description = resources.getString(R.string.xor_gate_description),
            icon = R.drawable.xor,
            truthTable = R.drawable.xor_truth_table
        ),
        Component(
            id = 4,
            name = resources.getString(R.string.ground_gate_name),
            title = resources.getString(R.string.ground_title),
            description = resources.getString(R.string.ground_description),
            icon = R.drawable.ground,
            truthTable = 0
        ),
        Component(
            id = 5,
            name = resources.getString(R.string.voltage_gate_name),
            title = resources.getString(R.string.voltage_title),
            description = resources.getString(R.string.voltage_description),
            icon = R.drawable.voltage,
            truthTable = 0
        ),
        Component(
            id = 6,
            name = resources.getString(R.string.led_gate_name),
            title = resources.getString(R.string.led_title),
            description = resources.getString(R.string.led_gate_description),
            icon = R.drawable.led_off,
            truthTable = 0
        )
    )
}