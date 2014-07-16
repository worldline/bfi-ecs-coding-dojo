//
//  FakeEngine.m
//  TDD-Car-01
//
//  Copyright (c) 2014 Company. All rights reserved.
//

#import "FakeEngine.h"

@implementation FakeEngine

- (id)initWithSound:(NSString *)sound_ {
    
    if ( self = [super init] ) {
        self->sound = sound_;
        return self;
        
    } else
        
        return nil;
    
}

- (NSString*) start {
	self->startCalled = true;
    return self->sound;
}

- (bool) isStartCalled {
    return startCalled;
}

@end
