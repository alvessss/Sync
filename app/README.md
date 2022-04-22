<h2>A beautiful way to stack async code</h2>

        countSeconds(10).doAfter( ()-> {
            Log.i(TAG, "10 seconds have passed");
        });

        Goal countSeconds(int n){
            Goal goal = new Goal();
            new Thread( ()-> {
                // custom code
                int i;
                for (i = 0; i < n; i++) {
                    Log.i(TAG, Integer.toString(i));
                    try {
                        Thead.sleep(1000);
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }

                // goal condition
                if (i == n) {
                    goal.reached = true;
                }
                
                // error handling ?
                
            }).start();

            return goal;
        }