package org.example;

/*
Music: https://open.spotify.com/track/1ZcxexxlkOQXYSWjUJNxIz?si=7AR8AtSuSji7zMAhI4dVCQ

Make Me Forget
Sub Urban

I think about it sometimes
The way your words can itch my ears
And if I know you, and I might
That misalignment in your tears
Bizarre
I hardly touched you
Your skin's too hard
To leave a puncture
And in our crux
We become slugs again
Oh, again
Oh
Guess her name
It might just tongue-tie
The less I say
The more you confide
And this old shame
Of mine could float to the top
To the top
I want you to make
Me forget
Who I am tonight
Am tonight
I want you to make
Me forget
Who I am tonight
Am tonight
How she blurred through my hands
Sabotaged through the blood
Hoarding your flesh in the way that it was
To be soldered to nodes I preserve our love
Our love
I want you to make
Me forget
I want you to make
Me forget
Who I am tonight
Am tonight
I think about it sometimes
The way your words can itch my ears
And if I know you, and I might
That misalignment in your tears
Bizarre
I hardly touched you
Your skin's too hard
To leave a puncture
And in our crux
We become slugs again
Oh, again (and in our crux
We become slugs again)
Oh
Guess her name
It might just tongue-tie
The less I say
The more you confide
And this old shame
Of mine could float to the top
To the top (to the top)
I want you to make
Me forget
Who I am tonight
Am tonight
I want you to make
Me forget
Who I am tonight
Am tonight
I want you to make
Me forget
Who I am tonight
Am tonight
I want you to make me forget
Who I am tonight
Am tonight
I want you to make
Me forget
Who I am tonight
I want you to make
Me forget
Who I am tonight
Am tonight
 */

public class Main {
    public static void main(String[] args) {
        Person she = new Person("She", "skin too hard to leave a puncture", "untouchable");
        Memory misalignment = new Memory("misalignment in tears", 10, 10);
        Emotion longing = new Emotion("longing to forget", 10, 10);
        System.out.println(she.getName() + " carries the " + misalignment.getContent() + " while feeling " + longing.getType() + ".");
    }
}