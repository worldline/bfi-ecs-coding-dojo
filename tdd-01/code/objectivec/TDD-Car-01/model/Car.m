//
//  Car.m
//  TDD-Car-01
//
//  Created by AWL_02 on 16/06/2014.
//  Copyright (c) 2014 Company. All rights reserved.
//

#import "Car.h"
#import "Engine.h"

@implementation Car

- (id)initWithEngine:(Engine *)engine_ {

    if ( self = [super init] ) {
        self->engine = engine_;
        return self;

    } else

        return nil;

}

-(NSString*)start {
    return [engine start];
}

@end
