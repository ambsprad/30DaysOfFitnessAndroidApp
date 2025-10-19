package com.example.a30daysfitness.data
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.Workout

object WorkoutDataProvider {
    val defaultWorkout = getWorkoutData()[0]

    fun getWorkoutData(): List<Workout> {
        return listOf(
            Workout(
                id = 1,
                dayId = R.string.day1,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.legs,
                workoutPlan = R.string.leg_workout_detail
            ),
            Workout(
                id = 2,
                dayId = R.string.day2,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.chestAndBack,
                workoutPlan = R.string.chest_back_workout_detail
            ),
            Workout(
                id = 3,
                dayId = R.string.day3,
                iconId = R.drawable.cardioicon,
                workoutTypeId = R.string.cardio,
                workoutPlan = R.string.cardio_workout_detail
            ),
            Workout(
                id = 4,
                dayId = R.string.day4,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.abs,
                workoutPlan = R.string.abs_workout_detail
            ),
            Workout(
                id = 5,
                dayId = R.string.day5,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.shouldersAndArms,
                workoutPlan = R.string.shoulder_arms_workout_detail
            ),
            Workout(
                id = 6,
                dayId = R.string.day6,
                iconId = R.drawable.cardioicon,
                workoutTypeId = R.string.cardio,
                workoutPlan = R.string.cardio_workout_detail
            ),
            Workout(
                id = 7,
                dayId = R.string.day7,
                iconId = R.drawable.restday,
                workoutTypeId = R.string.rest,
                workoutPlan = R.string.rest_workout_detail
            ),
            Workout(
                id = 8,
                dayId = R.string.day8,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.legs,
                workoutPlan = R.string.leg_workout_detail
            ),
            Workout(
                id = 9,
                dayId = R.string.day9,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.chestAndBack,
                workoutPlan = R.string.chest_back_workout_detail
            ),
            Workout(
                id = 10,
                dayId = R.string.day10,
                iconId = R.drawable.cardioicon,
                workoutTypeId = R.string.cardio,
                workoutPlan = R.string.cardio_workout_detail
            ),
            Workout(
                id = 11,
                dayId = R.string.day11,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.abs,
                workoutPlan = R.string.abs_workout_detail
            ),
            Workout(
                id = 12,
                dayId = R.string.day12,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.shouldersAndArms,
                workoutPlan = R.string.shoulder_arms_workout_detail
            ),
            Workout(
                id = 13,
                dayId = R.string.day13,
                iconId = R.drawable.cardioicon,
                workoutTypeId = R.string.cardio,
                workoutPlan = R.string.cardio_workout_detail
            ),
            Workout(
                id = 14,
                dayId = R.string.day14,
                iconId = R.drawable.restday,
                workoutTypeId = R.string.rest,
                workoutPlan = R.string.rest_workout_detail
            ),
            Workout(
                id = 15,
                dayId = R.string.day15,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.legs,
                workoutPlan = R.string.leg_workout_detail
            ),
            Workout(
                id = 16,
                dayId = R.string.day16,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.chestAndBack,
                workoutPlan = R.string.chest_back_workout_detail
            ),
            Workout(
                id = 17,
                dayId = R.string.day17,
                iconId = R.drawable.cardioicon,
                workoutTypeId = R.string.cardio,
                workoutPlan = R.string.cardio_workout_detail
            ),
            Workout(
                id = 18,
                dayId = R.string.day18,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.abs,
                workoutPlan = R.string.abs_workout_detail
            ),
            Workout(
                id = 19,
                dayId = R.string.day19,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.shouldersAndArms,
                workoutPlan = R.string.shoulder_arms_workout_detail
            ),
            Workout(
                id = 20,
                dayId = R.string.day20,
                iconId = R.drawable.cardioicon,
                workoutTypeId = R.string.cardio,
                workoutPlan = R.string.cardio_workout_detail
            ),
            Workout(
                id = 21,
                dayId = R.string.day21,
                iconId = R.drawable.restday,
                workoutTypeId = R.string.rest,
                workoutPlan = R.string.rest_workout_detail
            ),
            Workout(
                id = 22,
                dayId = R.string.day22,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.legs,
                workoutPlan = R.string.leg_workout_detail
            ),
            Workout(
                id = 23,
                dayId = R.string.day23,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.chestAndBack,
                workoutPlan = R.string.chest_back_workout_detail
            ),
            Workout(
                id = 24,
                dayId = R.string.day24,
                iconId = R.drawable.cardioicon,
                workoutTypeId = R.string.cardio,
                workoutPlan = R.string.cardio_workout_detail
            ),
            Workout(
                id = 25,
                dayId = R.string.day25,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.abs,
                workoutPlan = R.string.abs_workout_detail
            ),
            Workout(
                id = 26,
                dayId = R.string.day26,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.shouldersAndArms,
                workoutPlan = R.string.shoulder_arms_workout_detail
            ),
            Workout(
                id = 27,
                dayId = R.string.day27,
                iconId = R.drawable.cardioicon,
                workoutTypeId = R.string.cardio,
                workoutPlan = R.string.cardio_workout_detail
            ),
            Workout(
                id = 28,
                dayId = R.string.day28,
                iconId = R.drawable.restday,
                workoutTypeId = R.string.rest,
                workoutPlan = R.string.rest_workout_detail
            ),
            Workout(
                id = 29,
                dayId = R.string.day29,
                iconId = R.drawable.pinkworkouticon,
                workoutTypeId = R.string.legs,
                workoutPlan = R.string.leg_workout_detail
            ),
            Workout(
                id = 30,
                dayId = R.string.day30,
                iconId = R.drawable.lightpinkworkouticon,
                workoutTypeId = R.string.chestAndBack,
                workoutPlan = R.string.chest_back_workout_detail
            )



        )
    }
}