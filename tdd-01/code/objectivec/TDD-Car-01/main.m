//
//  main.m
//  TDD-Car-01
//
//  Created by AWL_02 on 16/06/2014.
//  Copyright (c) 2014 Company. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "model/Engine.h"
#import "model/Car.h"

void should_start_engine();
void should_start_engine_when_starting_car();
void should_start_car_INTEGRATION();
void assertTrue(bool condition, NSString* message);

int main(int argc, const char * argv[])
{
    @autoreleasepool {
		// Unit
		should_start_engine();
		should_start_engine_when_starting_car();

		// Integration
		INTEGRATION_should_start_car();
    }
    return 0;
}

void should_start_engine() {
	// Given
    Engine *engine = [[Engine alloc] init];

    // When
    NSString *sound = [engine start];

    // Then
    assertTrue([sound isEqualTo:@"vrooom"], @"Engine should start");
}

void should_start_engine_when_starting_car() {
	// Given
    FakeEngine *engine = [[FakeEngine alloc] initWithSound:@"tagazoo"];
    Car *car = [[Car alloc]initWithEngine:engine];

	// When
    NSString *sound = [car start];

	// Then
    assertTrue([fakeEngine isStartCalled], @"Starting car should start engine");
    assertTrue([sound isEqualTo:@"tagazoo"], @"Car should do the same song as engine");
}

void should_start_car_INTEGRATION() {
	// Given
    Engine *engine = [[Engine alloc] init];
    Car *car = [[Car alloc]initWithEngine:engine];

    // When
    NSString *sound = [car start];

    // Then
    assertTrue([sound isEqualTo:@"vrooom"], @"Car and its engine should start");
}

void assertTrue(bool condition, NSString* message) {
    if (condition) {
        NSLog([NSString stringWithFormat:@"OK - %@", message]);
    } else {
        NSLog([NSString stringWithFormat:@"Fail - %@", message]);
    }
}
