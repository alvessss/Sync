<h2>A beautiful way to stack async code</h2>

[![](https://jitpack.io/v/alvessss/Sync.svg)](https://jitpack.io/#alvessss/Sync)

        countFunction(10).doAfter( ()-> {
            Log.i(TAG, "10 seconds have surely passed");
        });

        Goal countFunction(int n){
            Goal goal = new Goal();
            new Thread( ()-> {
                // custom code
                int i;
                for (i = 0; i < n; i++)
                    Log.i(TAG, Integer.toString(i));

                // goal condition
                if (i == n) {
                    goal.reached = true;
                }
                
                // error handling ?
                
            }).start();

            return goal;
        }